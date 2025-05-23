import { useState } from 'react';
import './TodoApp.css'

export default function TodoApp(){
    return(
        <div className="TodoApp">
            Todo Management Application
            <LoginComponent />
        </div>
    );
}

function LoginComponent(){

    const [username, setUsername] = useState("admin");
    const [password, setPassword] = useState("");
    const [showSuccessMessage, setShowSuccessMessage] = useState(false);
    const [showErrorMessage, setShowErrorMessage] = useState(false);

    function handleUsernameChange(event){
        setUsername(event.target.value);
    }

    function hanlePasswordChange(event){
        setPassword(event.target.value);
    }

    function handleSubmit(){
        if(username === "admin" && password === "dummy"){
            setShowSuccessMessage(true);
            setShowErrorMessage(false);
        }
        else{
            setShowSuccessMessage(false);
            setShowErrorMessage(true);
        }
    }

    function SuccessMessageComponent(){
        if(showSuccessMessage){
            return <div className='successMessage'>Authenticated Successfully</div>
        }
        
        return null;
    }

    function ErrorMessageComponent(){
        if(showErrorMessage){
            return(
                <div className='errorMessage'>
                    Authenticated Failed. Please check your credentials
                </div>
            );
        }
        return null;
    }

    return (
        <div className="Login">
            <SuccessMessageComponent />
            <ErrorMessageComponent />
            <div className="LoginForm">
                <div>
                    <label>User Name:</label>
                    <input type="text" name="username" value={username}
                        onChange={handleUsernameChange}    
                    />
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password}
                        onChange={hanlePasswordChange}
                    />
                </div>
                <div>
                    <button type="button" name="login"
                        onClick={handleSubmit}
                    >login</button>
                </div>
            </div>
        </div>
    );
}

// function WelcomeComponent(){
//     return (
//         <div className="Welcome">
//             Welcome Component
//         </div>
//     );
// }