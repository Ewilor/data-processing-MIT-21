<template>
  <div v-if="book">
    <ul>
      <li>{{ book.title }}</li>
      <li>{{ book.author }}</li>
      <li>{{ book.pages }}</li>
      <li><img :src='book.imageUrl' :style="{width: '40px', height: '40px'}"/></li>
    </ul>
  </div>
</template>


<script setup>
  import { ref, onMounted } from 'vue';
  const book = ref(null);
  onMounted(async () => {
    const response = await fetch('./literature');
    book.value = await response.json()
  })
</script>