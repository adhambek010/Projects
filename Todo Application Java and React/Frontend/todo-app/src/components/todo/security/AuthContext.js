import { createContext, useContext, useState } from "react";
import { executeBasicAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";

export const AuthContext =  createContext(); 

export const useAuth = () => useContext(AuthContext);

export default function AuthProvder({children}){

    const [isAuthenticated, setAuhenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    // function login(username, password){
    //     if(username === "user" && password === "8080"){
    //         setUsername(username);
    //         setAuhenticated(true);
    //         return true;
    //     }else{
    //         setAuhenticated(false);
    //         setUsername(null);
    //         return false;
    //     }
    // };

    async function login(username, password){

        const baToken = 'Basic ' + window.btoa(username + ":" + password);
        // token = baToken;
        
        try{
            const response = await executeBasicAuthenticationService(baToken)

            if(response.status === 200){
                setUsername(username);
                setAuhenticated(true);
                setToken(baToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log('intercepting and adding a token');
                        config.headers.Authorization = baToken;
                        return config;
                    }
                )

                return true;
            }else{
                logout();
                return false;
            } 
        } catch(error) {
            logout();
            return false;
        }
    };

    function logout(){
        setAuhenticated(false);
        setToken(null);
        setUsername(null);
    };

    return(
        <AuthContext.Provider value={{ isAuthenticated, login , logout, username, token }}>
            {children}
        </AuthContext.Provider>
    );
};