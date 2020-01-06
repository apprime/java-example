import React, {useState, useEffect} from 'react';
import { Button } from 'react-materialize';
import TableRows from './TableRows.js';
import axios from 'axios';

export default function List() {

    const [totalCost, setTotalCost] = useState(0);
    const [totalWeight, setTotalWeight] = useState(0);
    const [listItems, setListItems] = useState([]);

    useEffect(() => {
        fetchList();
    }, []);

    async function fetchList(){
        const result = await axios.get("/box");
        setListItems(result.data);
        if(result.data.length > 0){
            setTotalCost(result.data.reduce((acc, curr) => acc + curr.cost, 0));
            setTotalWeight(result.data.reduce((acc, curr) => acc + curr.weight, 0));
        } else {
            setTotalCost(0);
            setTotalWeight(0);
        }
    }

    return (
    <>
        <h5>All current boxes</h5>
        <table>
            <thead>
              <tr>
                  <th>Name</th>
                  <th>Weight</th>
                  <th>Colour</th>
                  <th>Price</th>
                  <th>Country</th>
              </tr>
            </thead>

            <tbody>
                <TableRows items={listItems} />
            </tbody>
        </table>
        <div>
            Total Cost: { totalCost } SEK <br/>
            Total Weight { totalWeight } kg
        </div>
        <Button
            onClick={fetchList}
            className="right"
            node="button"
            type="button"
            waves="light"
        >
            Refresh
        </Button>
    </>
    );
}
