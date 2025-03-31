<template>
  <div>
    <h1> Manage books system</h1>
  
    <h3>{{isEditing ? "Edit books list" : "Add new book"}}</h3>
    <form @submit.prevent="isEditing ? updateBook() : addBook()">
      <input v-model="currentBook.title" type="text" placeholder="Title">
      <input v-model="currentBook.author" type="text" placeholder="Author">
      <input v-model="currentBook.pages" type="number" placeholder="12">
      <input v-model="currentBook.imageUrl" type="text" placeholder="Book image">
      <input v-model="currentBook.isHardcover" type="text" placeholder="Book hardcover">
      <button type="submit">{{isEditing ? "Edit" : "Add"}}</button>
      <button type="button" v-if="isEditing" @click="cancelEdit()">Cancel</button>
    </form>

    <h1>List of the books</h1>
    <ul>
      <li v-for="book in books" :key="book.id">
        <h2>{{ book.title }}</h2>
        <h3>{{ book.author }}</h3>
        <p>{{ book.pages }}</p>
        <img :src='book.imageUrl' :style="{width: '40px', height: '40px'}"/>
        <p>{{ book.isHardcover ? "hardcover" : "paperback" }}</p>
        <button @click="editBook(book)">Edit</button>
        <button @click="deleteBook(book.id)">Remove</button>
      </li>
    </ul>
  </div>
</template>


<script setup>
  import { ref, onMounted } from 'vue';
  const books = ref(null);
  const currentBook = ref({id: null, title: "", author: "", pages: null, imageUrl: "", isHardcover: null})
  const isEditing = ref(false);

  const fetchBooks = async () => {
    try {
      const response = await fetch("/literature");
      books.value = await response.json();
      console.log("Отримані книги:", books.value);
    } catch (e) {
      console.error("Помилка при отриманні даних:", e);
    }
  };

  const addBook = async () => {
    try {
      const response = await fetch('./literature', {
        method: "POST",
        headers: {'Content-Type': "application/json"},
        body: JSON.stringify(currentBook.value),
      })

      if ( response.ok ) {
        fetchBooks();
        resetForm();
      }
    } catch (error) {
      console.error("Error during adding the book", error)
    }
  }

  const editBook = (book) => {
    currentBook.value = { ...book }
    isEditing.value = true;
  }

  const updateBook = async () => {
    try {
      const response = await fetch('./literature', {
        method: "PUT",
        headers: {'Content-Type': "application/json"},
        body: JSON.stringify(currentBook.value),
      })

      if ( response.ok ) {
        fetchBooks();
        resetForm();
      }
    } catch (error) {
      console.error("Error during updating the book", error)
    }
  }

  const deleteBook = async (id) => {
    try {
      const response = await fetch(`./literature?id=${id}`, { method: "DELETE" })

      if ( response.ok ) {
        fetchBooks();
      }
    } catch (e) {
      console.error("Error during deleting the book", e)
    }
  }

  const resetForm = () => {
    currentBook.value = { id: null, title: "", author: "", pages: null, imageUrl: "", isHardcover: null }
    isEditing.value = false;
  }

  const cancelEdit = () => {
    resetForm();
  }

  onMounted(fetchBooks)
</script>
