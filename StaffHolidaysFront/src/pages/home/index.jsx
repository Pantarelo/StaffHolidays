import { useEffect, useState } from "react"
import API from "../../scripts/api";

export default function Home(params) {

    const [name, setName] = useState("");
    const [listOfEmployee, setListOfEmployee] = useState(null);
    const [employee, setEmployee] = useState(null);

    const getEmployee = async () => {
        const respone = await API.get(`employee/${name}`);
        // console.log(respone.data);
        setEmployee(respone.data);
    }

    const getAllEmployee = async () => {
        const respone = await API.get("employee");
        setListOfEmployee(respone.data);
    }

    useEffect(() => {
        getAllEmployee();
    }, []);

    useEffect(() => {
        getEmployee();
    }, [name])

    return (
        <>
            <input className="flex w-96 justify-between items-center p-4 rounded-lg px-5 py-2 outline-none"  value={name} onChange={(input) => setName(input.target.value) } placeholder="Enter a name"></input>

           { 
                name == "" ?
                <section>
                    <h1>List of employees:</h1>
                    {
                        listOfEmployee && listOfEmployee.map((employee) =>  
                            <a href={`/employee/${employee.id}`}  className="flex justify-between w-96 p-5 rounded-lg bg-zinc-800 hover:bg-zinc-900 mt-10">
                                <span>
                                    {employee.name}
                                </span>
                                <span>
                                    {employee.position}
                                </span>
                            </a>
                    )
                    }
                </section>
                :
                employee ?
                    <section>
                        <h1>Employee:</h1>
                        <a href={`/employee/${employee.id}`}  className="flex justify-between w-96 p-5 rounded-lg bg-zinc-800 hover:bg-zinc-900 mt-10">
                            <span>
                                {employee.name}
                            </span>
                            <span>
                                {employee.position}
                            </span>
                        </a>
                    </section>
                    :
                    <h1>Employee not found!</h1>
            
            }
        </>
    )
};
