// Composables
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: "/login",
    name: "login",
    component: () => import('@/views/LoginView.vue'),
    meta: {
      requireAuth: false
    }
  },
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'inicio',
        component: () => import( '@/views/InicioView.vue'),
        meta: {
          requireAuth: true
        }
      },
   
      {
        path: '/guitarra',
        name: 'guitarra',
        component: () => import( '@/views/GuitarraView.vue'),
        meta: {
          requireAuth: true
        }

      },
      {
        path: '/persona',
        name: 'persona',
        component: () => import( '@/views/PersonasView.vue'),
        meta: {
          requireAuth: true
        }
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

router.beforeEach((to,from,next)=>{
  const token = localStorage.getItem("token");
  const requireAuth = to.meta.requireAuth
  if(requireAuth && !token){
    localStorage.clear();
    next('login');
  }else{
    next();
  }
});

export default router
