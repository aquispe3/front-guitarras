import axios from "axios";

import { defineStore } from "pinia";
import {ref} from 'vue';
import { headerConfig } from '@/composable/tokenComposable'
//const api_leal = import.meta.env.VITE_API_LEAL;
const api = import.meta.env.API_BACKEND_GUITARRA;





export const useGuitarraStore = defineStore("GuitarraStore", () => {
    const listaGuitarra = ref([]);


    const obtenerGuitarras = async () =>{
        console.log(headerConfig());
        let r =  await axios.get(`https://quickpay.com.bo:2024/api/guitarra/obtener-todos`,headerConfig());
        listaGuitarra.value = r.data.result;
    };
    const eliminarGuitarra = async(guitarraId) =>{
        await axios.delete(`https://quickpay.com.bo:2024/api/guitarra/eliminar/${guitarraId}`,headerConfig());
    };
    const editarGuitarra = async(objGuitarra) =>{
        await axios.put(`https://quickpay.com.bo:2024/api/guitarra/modificar`,objGuitarra,headerConfig());
    }
    const registrarGuitarra = async(objGuitarra) =>{
        await axios.post(`https://quickpay.com.bo:2024/api/guitarra/registrar`,objGuitarra,headerConfig());
    }
    return {
        obtenerGuitarras,listaGuitarra,eliminarGuitarra,editarGuitarra,registrarGuitarra
      }
});