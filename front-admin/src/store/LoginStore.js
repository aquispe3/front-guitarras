import axios from "axios";

import { defineStore } from "pinia";
import { registrarToken } from '@/composable/tokenComposable'
//const api_backend = import.meta.env.VITE_API_BACKEND;
const api = import.meta.env.VITE_API_BACKEND_GUITARRA;

export const useLoginStore = defineStore("LoginStore", () => {


    const autentication = async (obj) =>{
        let r = {};
        try {
            r =  await axios.post(`${api}/auth/login`,obj);  
            registrarToken(r.data.token);
        } catch (error) {
            r = {
                status:'404',
                token:''
            }
        }
        return r;
    };
    const registrar = async (obj) =>{
        console.log("ingresando  store")
        let r =  await axios.post(`https://quickpay.com.bo:2024/auth/register`,obj);
        return r;
    };

    return {
        autentication,registrar
      }

});