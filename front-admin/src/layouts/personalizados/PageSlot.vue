<template>
    <v-card
      class="mx-auto ma-10"
      width="95%"
      elevation="2"
    >
      <v-card-title class="text-center" >
        <h2  >
          <slot name="title">
  
        </slot>
      </h2>
      </v-card-title>
  
      <v-divider></v-divider>
      <v-card-text style="height: 100%;">
        <slot name="content">
          
        </slot>
      </v-card-text>
    </v-card>
  </template>
  
  