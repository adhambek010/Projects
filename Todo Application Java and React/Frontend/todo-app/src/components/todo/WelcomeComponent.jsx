import {useParams, Link } from 'react-router-dom';
import { useState } from 'react';
import { retrivePathVariable } from './api/HelloWorldApiService';
import { useAuth } from './security/AuthContext';

function WelcomeComponent(){

    const {username} = useParams();
    const [message, setMessage] = useState(null);
    const authContext = useAuth();
    
    function callHelloworlRestApi(){
        console.log('Called');

        retrivePathVariable('Adham', authContext.token)
            .then( (respnse) =>  successfulResponse(respnse) )
            .catch( (error) => errorResponse(error) )
            .finally(() => console.log("Cleaned up!"));
    }

    function successfulResponse(respnse){
        console.log(respnse);
        setMessage(respnse.data.message);
    }

    function errorResponse(error){
        console.log(error);
    }

    return(
        <div>
            <div className='WelcomeComponent'><h1>Welcome to {username} </h1></div>
            <div>
                Manage your todos <Link to='/todos'>Click here</Link>
            </div>
            <div>
                <button className="btn btn-success m-3" onClick={callHelloworlRestApi}>Call Hello World Rest Api</button>
            </div>
            <div className='text-info'>{message}</div>
        </div>
    );
};
export default WelcomeComponent;