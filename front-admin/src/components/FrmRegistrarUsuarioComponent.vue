<template>
    <!-- formulario para registro de personas -->
    <v-card class="mx-auto" width="500" title="Formulario de Guitarra">
        <v-container>
            <v-text-field color="primary" v-model="objPersona.username" label="User Name" variant="underlined"></v-text-field>
            <v-text-field color="primary" v-model="objPersona.password" label="Contraseña" variant="underlined"></v-text-field>
            <v-text-field color="primary" v-model="objPersona.firstname" label="Nombre" variant="underlined"></v-text-field>
            <v-text-field color="primary" v-model="objPersona.lastname" label="Apellidos" variant="underlined"></v-text-field>
            
            <v-autocomplete
            v-model="objPersona.country"
            label="Seleccione Paises"
            :items="lstPaises"
            ></v-autocomplete>

        {{ objPersona}}
        </v-container>
        <v-divider></v-divider>
        <v-card-actions>
            <v-btn color="success" @click="registrarUsuario()">
                Registrar
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script setup>
import {ref} from 'vue';
const lstPaises = ["BOLIVIA","CHILE","ARGENTINA"];
import { useLoginStore } from "@/store/LoginStore";
const loginStore = useLoginStore();

/*const userName = ref("");
const contrasenia = ref("");
const nombre = ref("");
const apellido = ref("");
const paises = ref("");*/


const objPersona = ref({});


const registrarUsuario = async () =>{
 
    let r = await loginStore.registrar(objPersona.value);
    if(!r.data.token){
        alert("usuario no creado con exito");
    }
}
</script>