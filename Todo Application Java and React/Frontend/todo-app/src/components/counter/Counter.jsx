import { useState } from 'react';
import './Counter.css';
import CounterButton from'./CounterButton';

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by) {
        setCount(count + by);
    };

    function decrementCounterParentFunction(by) {
        setCount(count - by);
    };

    function resetParent(){
        setCount(0);
    };

    return (
        <div>
            <div>
            <span className='totalCount'>{count}</span>
            <CounterButton incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
            <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
            <CounterButton by={3} incrementMethod={incrementCounterParentFunction} decrementMethod={decrementCounterParentFunction} />
            {/* <ResetButton reset={resetParent} /> */}
            <button className='resetButton' onClick={resetParent}>Reset</button>
            </div>
        </div>
    );
};