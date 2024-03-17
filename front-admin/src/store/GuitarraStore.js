import axios from "axios";

import { defineStore } from "pinia";
import {ref} from 'vue';
import { headerConfig } from '@/composable/tokenComposable'


export const useGuitarraStore = defineStore("GuitarraStore", () => {
    const listaGuitarra = ref([]);


    const obtenerGuitarras = async () =>{
        console.log(headerConfig());
        let r =  await axios.get(`http://localhost:2024/api/guitarra/obtener-todos`,headerConfig());
        listaGuitarra.value = r.data.result;
    };
    const eliminarGuitarra = async(guitarraId) =>{
        await axios.delete(`http://localhost:2024/api/guitarra/eliminar/${guitarraId}`,headerConfig());
    };
    const editarGuitarra = async(objGuitarra) =>{
        await axios.put(`http://localhost:20240/api/guitarra/modificar`,objGuitarra,headerConfig());
    }
    const registrarGuitarra = async(objGuitarra) =>{
        
    }
    return {
        obtenerGuitarras,listaGuitarra,eliminarGuitarra,editarGuitarra
      }

});