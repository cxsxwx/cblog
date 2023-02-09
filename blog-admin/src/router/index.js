import VueRouter from "vue-router";
import home from '../views/manage/home'
import Mindex from '../views/manage/views/mindex'
import SaveBlog from '../views/manage/views/saveBlog'
import UpdateBlog from '../views/manage/views/updateBlog'
import Type from '../views/manage/views/type'
import Label from '../views/manage/views/label'
import Login from '../components/login.vue'
import Blog from '../views/manage/views/blog'




const router =new VueRouter({
    routes:[
        {path:'/',redirect:'/login'},
        {path:'/login',component:Login},
        
        {
            path:"/home",
            component: home,
            name:'home',
            redirect:'/index',
            children:[
                {
                    path:'/index',
                    component: Mindex,
                    name:'index',
                },
                {
                    path:'/saveBlog',
                    component: SaveBlog,
                    name:'saveBlog',
                },
                {
                    path:'/updateBlog',
                    component: UpdateBlog,
                    name:'updateBlog',
                },
                {
                    path:'/type',
                    component: Type,
                    name:'type',
                },
                {
                    path:'/label',
                    component: Label,
                    name:'label',
                },
                {
                    path:'/blog',
                    name:'blog',
                    component:Blog,
                }
            ]
        }
    ]
})
export default router
