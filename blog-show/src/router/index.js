import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
    { path: '/', redirect: '/main' },
    {
        path: '/index',
        component: () => import('../components/index.vue'),
        name: 'index',
        children: [
            {
                path: '/main',
                component: () => import('../views/Main.vue'),
                name: 'main'
            },
            {
                path: '/single',
                name: 'single',
                component: () => import('../views/Single.vue'),
            },
            {
                path: '/posts',
                name: 'posts',
                component: () => import('../views/Posts.vue')
            },
            {
                path: '/category',
                name: 'category',
                component: () => import('../views/Category.vue')
            },
            {
                path: '/labels',
                name: 'labels',
                component: () => import('../views/Labels.vue')
            },
            {
                path:'/about',
                name:'about',
                component:() => import('../views/About.vue')  
            }

        ]
    },


]

const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router;