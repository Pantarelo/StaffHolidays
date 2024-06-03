import { useParams } from "react-router-dom";
import API from "../../scripts/api";
import { useEffect, useState } from "react";

export default function Holiday(params) {

    let { holidayId } = useParams();
    const [holiday, setHoliday] = useState({});

    const getHoliday = async () => {
        const response = await API.get(`holiday/${holidayId}`);
        setHoliday(response.data);
        console.log(holiday)
    }

    useEffect(() => {
        getHoliday();
    },[])
    return (
        <>
            <h1>{holiday.location ? holiday.location.name : "-"}</h1>
            <div className="flex flex-col">
                {
                    holiday.location && holiday.location.attractions.map((attraction) => 
                        <div key={attraction.id} className="w-full bg-zinc-800 px-10 py-2 rounded-xl m-2 grid grid-cols-3 gap-4">
                            <span>{attraction.name}</span>
                            <span className="flex items-center justify-center">{attraction.openingTime}</span>
                            <span className="flex items-center justify-center">{attraction.closeTime}</span>
                        </div>

                    )
                }
            </div>
        </>
    );
};
