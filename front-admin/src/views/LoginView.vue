<template>
  <v-card class="mx-auto pa-12 pb-8 mt-10" elevation="8" max-width="448" rounded="lg">
    
    <v-alert
    type="success"
      variant="outlined"
    >
    {{ abrirDialogo }}
      En caso de ser usuario nuevo porfavor <a href="#" @click.prevent="abrirFormulario()">registrese</a> 
    </v-alert>
    <div class="text-subtitle-1 text-medium-emphasis">Usuario</div>
    <v-text-field id="usuario" v-model="email" density="compact" placeholder="Usuario / Correo" prepend-inner-icon="mdi-email-outline"
      variant="outlined"></v-text-field>

    <div class="text-subtitle-1 text-medium-emphasis d-flex align-center justify-space-between">
      Password
    </div>

    <v-text-field id="contrasenia" v-model="contrasenia" :append-inner-icon="visibleLogin ? 'mdi-eye-off' : 'mdi-eye'"
      :type="visibleLogin ? 'text' : 'password'" density="compact" placeholder="Ingrese password"
      prepend-inner-icon="mdi-lock-outline" variant="outlined"
      @click:append-inner="visibleLogin = !visibleLogin"></v-text-field>

      <v-btn
      id="btnIngresar"
        :disabled="loading"
        :loading="loading"

        class="text-none mb-4"
        color="indigo-darken-3"
        size="x-large"
        variant="flat"
        block
        @click="autenticar()"
      >
        Ingresar
        </v-btn>
    <h4 v-if="error">Error al autenticar</h4>

    <v-btn class="mb-8" color="blue" size="large" variant="tonal" block @click="loginFirebase()">
      Ingresar con Firebase
    </v-btn>
    <v-btn class="mb-8" color="blue" size="large" variant="tonal" block @click="loginGoogle()">
      Ingresar con Google
    </v-btn>
    <v-btn class="mb-8" color="blue" size="large" variant="tonal" block @click="loginGithub()">
      Ingresar con Github
    </v-btn>

  </v-card>


  <v-dialog v-model="abrirDialogo" width="auto">
    <FrmRegistrarUsuarioComponent></FrmRegistrarUsuarioComponent>
  </v-dialog>

</template>
<script setup>
import {ref} from 'vue';
import  {getAuth, signInWithEmailAndPassword,GoogleAuthProvider,GithubAuthProvider,signInWithPopup} from 'firebase/auth';
import {useRouter} from 'vue-router';
import FrmRegistrarUsuarioComponent from './../components/FrmRegistrarUsuarioComponent.vue'
const router = useRouter();
const googleProvider = new GoogleAuthProvider();
const githubAuthProvider = new GithubAuthProvider();
const visibleLogin = ref(false);

let email = ref("");
let contrasenia = ref("");
const auth = getAuth();
const loading = ref(false);
const error = ref(false);

let abrirDialogo = ref(false);

import { useLoginStore } from "@/store/LoginStore";
const loginStore = useLoginStore();

const abrirFormulario = () =>{
  abrirDialogo.value = true;
}
const autenticar = async () =>{
  let obj = {
    username:email.value,
    password:contrasenia.value
  };

  loading.value = true;
  let r = await loginStore.autentication(obj);
  loading.value = false;
  error.value = false;
  if(r.data?.status==200){
    router.push({name:"inicio"});
  }else{
    error.value = true;
  }
}

const loginFirebase = ()=>{
    
    signInWithEmailAndPassword(auth,email.value,contrasenia.value).then(
        (r)=>{
            let token = r._tokenResponse.idToken;
     
            if(token){
                
                router.push({name:"inicio"});
            }else{
                alert("no hay token");
            }
        }
    ).catch((e)=>{
        alert("Error en la autenticacion");
    })
    
}

const loginGoogle = () =>{

  signInWithPopup(auth,googleProvider).then(
        (result) =>{
            const credencial = GoogleAuthProvider.credentialFromResult(result);
            console.log(credencial);
            const token = credencial?.accessToken;
            console.log(token);
            router.push({name:"inicio"});
            //alert("Success");
            
        }
    ).catch(
        (error)=>{
            alert(error)
        }
    );
}
const loginGithub = () =>{
  signInWithPopup(auth,githubAuthProvider).then(
        (result)=>{
            const credencial = GithubAuthProvider.credentialFromResult(result);
            console.log(credencial);
            const token = credencial?.accessToken;
            console.log(token);
            router.push({name:"inicio"});
        }
    ).catch(
        (error)=>{
            console.log(error)
        }
    );
}



</script>