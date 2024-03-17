/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'

const app = createApp(App)

registerPlugins(app)



// ========== config firebase
import { initializeApp } from "firebase/app";
const firebaseConfig = {
  apiKey: "AIzaSyDcZEWeUdNkcZmvmJR_kxex9MEXfnQheiY",
  authDomain: "clase-vue3-icei.firebaseapp.com",
  projectId: "clase-vue3-icei",
  storageBucket: "clase-vue3-icei.appspot.com",
  messagingSenderId: "617595596582",
  appId: "1:617595596582:web:394aa1c0527c1228165be7"
};
initializeApp(firebaseConfig);
// ==========================


app.mount('#app')
