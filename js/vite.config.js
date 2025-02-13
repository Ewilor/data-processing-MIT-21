import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'


// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  server: {
    proxy: {
      '/literature': {
        target: 'http://localhost:8080/Lab2-2.0-SNAPSHOT/',
        changeOrigin: true,
        secure: false
      }
    }
  }
});
