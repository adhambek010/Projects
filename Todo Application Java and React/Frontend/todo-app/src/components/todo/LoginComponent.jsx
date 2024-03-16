import { useNavigate, } from 'react-router-dom';
import { useState } from 'react';
import { useAuth } from './security/AuthContext';

function LoginComponent() {

    const [username, setUsername] = useState("user");
    const [password, setPassword] = useState("");
    const [showErrorMessage] = useState(false);
    const navigate = useNavigate();
    const authContext = useAuth();

    function handleUsernameChange(event){
        setUsername(event.target.value);
    };

    function handlePasswordChange(event){
        setPassword(event.target.value);
    };

    async function handleSubmit(){
        if(await authContext.login(username, password)){
            navigate(`/welcome/${username}`);
        }
    };

    return(
        <div className="Login">
            <div className = "LoginForm">
                <h1>Time to Login!!!</h1>
                {showErrorMessage && <div className='errorMessage'>Authentication Failed. Please check your credentials.</div>}
                <label>User Name</label>
                <input type="text" name="username" value={username} onChange={handleUsernameChange} />
            </div>
            <div>
                <label>Password</label>
                <input type="password" name="password" value={password} onChange={handlePasswordChange} />
            </div>
            <div>
                <button type="button" name="login" onClick={handleSubmit}>LOGIN</button>
            </div>
        </div>
    );
};
export default LoginComponent;