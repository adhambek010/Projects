// CounterButton.jsx
// import React, { useState } from 'react';
import PropTypes from 'prop-types';
import './Counter.css';

export default function CounterButton({ by, incrementMethod, decrementMethod}) {

    //const [count, setCount] = useState(0);

    // function incrementCounterFunction() {
    //     // setCount(count + 1);
    //     incrementMethod(by);
    // };

    // function decrementCounterFunction() {
    //     // setCount(count - 1)
    //     decrementMethod(by);
    // };


    return (
        <div>
            <div className="CounterButton">
            <div>
                <button className="counterButton" onClick={() => incrementMethod(by)}>
                    +{by}
                </button>
                <button className="counterButton" onClick={() => decrementMethod(by)}>
                    -{by}
                </button>
            </div>
        </div>
        </div>
    );
};

CounterButton.propTypes = {
    by: PropTypes.number,
};

CounterButton.defaultProps = {
    by: 1
};
