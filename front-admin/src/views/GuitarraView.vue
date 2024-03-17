<template>
    <PageSlot>
        <template #title>
            tabla de guitarras
        </template>
        <template #content>

            <button @click="guitarraStore.obtenerGuitarras()" >Actualizar </button>
            <!-- dialogo-->
            <v-dialog v-model="abrirDialogo" width="auto">
                <!-- formulario para registro y modificaion -->
                <v-card class="mx-auto" width="500" title="Formulario de Guitarra">
                    <v-container>
                        <v-text-field color="primary" label="Nombre" v-model="objGuitarra.nombre" variant="underlined"></v-text-field>
                        <v-text-field color="primary" label="Descripción" v-model="objGuitarra.descripcion" variant="underlined"></v-text-field>
                        <v-text-field color="primary" label="Costo" v-model="objGuitarra.costo" variant="underlined"></v-text-field>
                    </v-container>
                    <v-divider></v-divider>
                    <v-card-actions>
                        <v-btn color="success">
                            Registrar
                        </v-btn>
                    </v-card-actions>
                </v-card>

            </v-dialog>

            <!-- tabla -->
            <v-data-table :headers="cabeceraTable" :items="guitarraStore.listaGuitarra">

                <template v-slot:item="{ item }">
                    <tr>
                        <td class="font-weight-regular">{{ item.guitarraId + " " + item.nombre }}</td>
                        <td class="font-weight-regular">{{ item.descripcion }}</td>
                        <td class="font-weight-regular">{{ item.costo }}</td>
                        <td class="font-weight-regular">{{ item.img }}</td>
                        <td class="font-weight-regular">{{ convertToDDMMYYYY(item.fechaRegistro) }}</td>
                        <td>
                            <v-icon class="me-2" color="teal" size="small" @click="editarGuitarra(item)">
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


const editarGuitarra = async (item) => {
    abrirDialogo.value = true;
    objGuitarra.value= item;
}

const actualizarGuitarra = async () => {
    let r = await guitarraStore.editarGuitarra(objGuitarra);
}








/*import { useDeudaClienteStore } from "@/store/DeudaClienteStore";
const deudaClienteStore = useDeudaClienteStore();
await deudaClienteStore.getDeudaClienteByEntidadIdAndCodigoCliente(*/

</script>