import { useParams } from "react-router-dom";
import API from "../../scripts/api";
import { useEffect, useState } from "react";
import { MdEdit } from "react-icons/md";
import { MdDelete } from "react-icons/md";
import Popup from 'reactjs-popup';

export default function Employee(params) {

    let { employeeId } = useParams();

    const [name, setName] = useState("");
    const [position, setPosition] = useState("");

    const [listOfHolidays, setListOfHolidays] = useState("");
    const [listOfLocations, setListOfLocations] = useState([]);
    const [listOfAttractions, setListOfAttractions] = useState([]);
    
    const [employee, setEmployee] = useState(null);

    const getEmployeeById = async () => {
        const response = await API.get(`employee/id/${employeeId}`) 
        setEmployee(response.data);
        setName(response.data.name);
        setPosition(response.data.position);
    }


    const getHolidaysList = async () => {
        const response = await API.get(`employee/holidays/${employeeId}`)
        setListOfHolidays(response.data);
    }

    const getAttractions = async () => {
        const response = await API.get(`location/attractions/${location.name}`);
        setListOfAttractions(response.data);
    }

    const getLocations = async () => {
        const response = await API.get('location')
        setListOfLocations(response.data);

        getAttractions();
    }

    const deleteHoliday = async (id) => {
        const response = await API.delete(`holiday/${id}`)
        console.log(response);
    }


    const [startDate, setStartDate] = useState(new Date());
    const [endDate, setEndDate] = useState(new Date());
    const [location, setLocation] = useState("Barcelona");
    const [idLocation, setIdLocation] = useState(4);
    const [attraction, setAttraction] = useState("");
    const [startTime, setStartTime] = useState(null);
    const [endTime, setEndTime] = useState(null);


    useEffect(() => {
        getLocations();
        getHolidaysList();
        getEmployeeById();
        getAttractions();
    },[])

    useEffect(()=> {
        getAttractions();
        console.log(location);
    },[location])

    useEffect(()=> {
        console.log(attraction);
        setStartTime(attraction.openingTime);
        setEndTime(attraction.closeTime);
    }, [attraction])

    const postNewHoliday = async () => {
        const newHoliday = {
            "startTime" : startDate,
            "endTime" : endDate,
            "employee" : employee,
            "location" : location
        }
        const response = await API.post(`holiday`, newHoliday)

        console.log(response);
    }


    return (
        <>
            <div className="flex flex-col justify-center items-center">
                <h1>Employee: {name}</h1>
                <span>Position: {position}</span>


                <Popup trigger={ <button className="w-fit mt-10">Add new holiday</button>} modal nested>
                    <div className="flex flex-col justify-center items-center bg-zinc-800 h-[40em] w-[70em] rounded-xl">
                        <div className="flex flex-col h-96 justify-between">
                            
                            <div className="flex flex-col">
                                <label>Start date</label>
                                <input onChange={(date) => setStartDate(date.target.value)}  id="startDate" type="date" placeholder="Start date"></input>
                            </div>
                            <div className="flex flex-col">
                                <label>End date</label>
                                <input onChange={(date) => setEndDate(date.target.value)} id="endDate" type="date" placeholder="End date"></input>
                            </div>

                            <div className="flex flex-col" >
                                <label>Set a location</label>
                                <select id="selectLocation" onChange={(currentLocation) => {setLocation(JSON.parse(currentLocation.target.value)); }}>
                                    {
                                        listOfLocations.map((location) => 
                                            <option value={JSON.stringify(location)}>{location.name}</option>
                                        )
                                    }
                                </select>
                            </div>

                            

                            <div className="flex flex-col" >
                                <label>Set a attraction</label>
                                <select id="selectLocation" onChange={(currentLocation) => setAttraction(JSON.parse(currentLocation.target.value))}>
                                    {
                                        listOfAttractions.map((attraction) => 
                                            <option value={
                                                JSON.stringify(attraction)
                                            }>{attraction.name}</option>
                                        )
                                    }
                                </select>

                                
                            </div>

                            <div className="flex flex-col">
                                <label>Start time</label>
                                <input value={startTime} id="endDate" type="time"></input>
                            </div>
                            <div className="flex flex-col">
                                <label>End time</label>
                                <input value={endTime} id="endDate" type="time"></input>
                            </div>
                           

                            <button onClick={postNewHoliday}>Add new holiday</button>
                        </div>

                    </div>
                </Popup>
               
            </div>
            <div className="flex flex-col h-80 overflow-y-scroll overflow-x-clip m-10 bg-zinc-900 p-10 rounded-xl">
                {
                    listOfHolidays && listOfHolidays.map((holiday) => 
                        <>
                            <a href={`/holiday/${holiday.id}`} key={holiday.id} className="w-full bg-zinc-800 px-10 py-2 rounded-xl m-2 grid grid-cols-3 gap-4">
                                <span className="flex items-center justify-center">{new Date(holiday.startTime).toDateString()} - {new Date(holiday.endTime).toDateString()}</span>
                                <span className="flex items-center justify-center">{holiday.location ? holiday.location.name : "-"}</span>
                                <div className="w-36 flex justify-end items-center">
                                    <button className="m-2"><MdEdit/></button>
                                    <button onClick={()=> deleteHoliday(holiday.id)}><MdDelete/></button>
                                </div>
                            </a>
                        </>
                    )
                }
            </div>
        </>
    )
};
