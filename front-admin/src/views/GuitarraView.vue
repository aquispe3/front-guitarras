<template>
    <v-dialog v-model="dialog" max-width="320" persistent>
        <v-list class="py-2" color="primary" elevation="12" rounded="lg">
            <v-list-item prepend-icon="$vuetify-outline" title="Refreshing Application...">
                <template v-slot:prepend>
                    <div class="pe-4">
                        <v-icon color="primary" size="x-large"></v-icon>
                    </div>
                </template>

                <template v-slot:append>
                    <v-progress-circular color="primary" indeterminate="disable-shrink" size="16"
                        width="2"></v-progress-circular>
                </template>
            </v-list-item>
        </v-list>
    </v-dialog>

    <PageSlot>
        <template #title>
            {{ $t("message.titulo",{nameTitle:'Guitars'}) }}<br>
            {{ $t("message.titulo2",{count:guitarraStore.listaGuitarra.length})  }}
        </template>
        <template #content>

            <!--<button @click="guitarraStore.obtenerGuitarras()">Actualizar </button>-->
            <!-- dialogo-->
            <v-dialog v-model="abrirDialogo" width="auto">
                <!-- formulario para registro y modificaion -->
                <v-card class="mx-auto" width="500" title="Formulario de Guitarra">
                    <v-container>
                        <v-text-field color="primary" label="Nombre" v-model="objGuitarra.nombre"
                            variant="underlined"></v-text-field>
                        <v-text-field color="primary" label="Descripción" v-model="objGuitarra.descripcion"
                            variant="underlined"></v-text-field>
                        <v-text-field color="primary" label="Costo" v-model="objGuitarra.costo"
                            variant="underlined"></v-text-field>
                    </v-container>
                    <v-divider></v-divider>
                    <v-card-actions>
                        <v-btn color="success"  @click="insertOrUpdate()">
                            {{ objGuitarra.guitarraId ? 'Actualizar' : 'Insertar' }}
                        </v-btn>
                    </v-card-actions>
                </v-card>

            </v-dialog>

            <!-- tabla -->
            <v-col cols="auto">
                <v-btn color="blue" size="x-small" icon="mdi-plus"  @click="habrirDialogForm({})"></v-btn>
            </v-col>
            <v-data-table :headers="cabeceraTable" :items="guitarraStore.listaGuitarra">

                <template v-slot:item="{ item }">
                    <tr>
                        <td class="font-weight-regular">{{ item.guitarraId + " " + item.nombre }}</td>
                        <td class="font-weight-regular">{{ item.descripcion }}</td>
                        <td class="font-weight-regular">{{ item.costo }}</td>
                        <td class="font-weight-regular">{{ item.img }}</td>
                        <td class="font-weight-regular">{{ convertToDDMMYYYY(item.fechaRegistro) }}</td>
                        <td>
                            
                            <v-icon class="me-2" color="teal" size="small" @click="habrirDialogForm(item)">
                                mdi-pencil
                            </v-icon>
                            <v-icon class="me-2" color="pink" size="small" @click="eliminarGuitarra(item.guitarraId)">
                                mdi-delete
                            </v-icon>
                        </td>
                    </tr>
                </template>


            </v-data-table>


        </template>
    </PageSlot>
</template>

<script setup>
import { convertToDDMMYYYY } from "@/composable/fechasComposable";
import PageSlot from "@/layouts/personalizados/PageSlot.vue"
import { ref, onMounted } from 'vue';
import { useGuitarraStore } from "@/store/GuitarraStore";
const guitarraStore = useGuitarraStore();
//const listaGuitarra = ref([]);
const abrirDialogo = ref(false);
const dialog = ref(false);

const objGuitarra = ref({});
const cabeceraTable = [
    { title: 'Nombre' },
    { title: 'Descripción' },
    { title: 'Costo' },
    { title: 'Imagen' },
    { title: 'Fecha de registro' },
    { title: '' },
]
onMounted(() => {
    //listaGuitarra.value =  await  guitarraStore.obtenerGuitarras();
    guitarraStore.obtenerGuitarras();
});
const eliminarGuitarra = async (guitarraId) => {
    let puedeEliminar = confirm("Esta seguro de eliminar?");
    if (puedeEliminar) {
        await guitarraStore.eliminarGuitarra(guitarraId);
        guitarraStore.obtenerGuitarras();
    }
}


const habrirDialogForm = async (item) => {
    abrirDialogo.value = true;
    objGuitarra.value = item;
}


const insertOrUpdate = async () => {
    dialog.value = true;
    console.log("ID de la gruitarra");
    console.log(objGuitarra.value.guitarraId)

    if (objGuitarra.value.guitarraId) {
        
        // modificar
        let r = await guitarraStore.editarGuitarra(objGuitarra.value);
    } else {
        // insert
        let r = await guitarraStore.registrarGuitarra(objGuitarra.value);
    }
    
    await  guitarraStore.obtenerGuitarras();
    dialog.value = false;


}








/*import { useDeudaClienteStore } from "@/store/DeudaClienteStore";
const deudaClienteStore = useDeudaClienteStore();
await deudaClienteStore.getDeudaClienteByEntidadIdAndCodigoCliente(*/

</script>