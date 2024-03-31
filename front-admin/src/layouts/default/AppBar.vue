<template>
<v-app-bar color="primary" prominent>
    <v-app-bar-nav-icon variant="text" @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
    <v-toolbar-title>SISTEMA</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-btn variant="text" icon="mdi mdi-logout" @click="salir()"></v-btn>
  </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
    
        
      >
        <v-list-item
          prepend-avatar="https://randomuser.me/api/portraits/men/85.jpg"
          title="John Leider"
          nav
        >
          
        </v-list-item>

        <v-divider></v-divider>

        <v-list density="compact" nav>
          <v-list-item prepend-icon="mdi mdi-home-alert-outline" title="Inicio" value="home"  @click="go('inicio')" ></v-list-item>
          <v-list-item prepend-icon="mdi mdi-account-star-outline" title="Personas" value="account" @click="go('persona')"></v-list-item>
          <v-list-item prepend-icon="mdi mdi-guitar-acoustic" title="Guitarra" value="users" @click="go('guitarra')"></v-list-item>
        </v-list>
      </v-navigation-drawer>

</template>

<!--<script>
  export default {
    data () {
      return {
        drawer: true,
        
      }
    },
    methods:{
      go(url){
        this.$router.push(url)
      }
    }
  }
</script>-->

<script setup>
import {ref} from 'vue';
import {useRouter} from 'vue-router';
import {limpiarToken} from '@/composable/tokenComposable'
const router = useRouter();

const drawer = ref(false);
const go=(name) =>{
  router.push({name:name});
}
const salir = () =>{
  localStorage.clear();
  router.push({name:'login'});
}

</script>
