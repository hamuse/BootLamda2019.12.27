import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/components/cmm/Layout.vue'
import Login from '@/components/member/Login.vue'
import Join from '@/components/member/Join.vue'
import MyPage from '@/components/member/MyPage.vue'
import MyPageUpdate from '@/components/member/MyPageUpdate.vue'
import StudentList from '@/components/member/StudentList.vue'
import StudentFindSome from '@/components/student/StudentFindSome.vue'
import StudentFindOne from '@/components/student/StudentFindOne.vue'
/* import Admin from '@/components/member/Admin.vue'
import Admin from '@/components/member/Admin.vue'
import Admin from '@/components/member/Admin.vue'
import Admin from '@/components/member/Admin.vue'
import Admin from '@/components/member/Admin.vue'
import Admin from '@/components/member/Admin.vue' */
Vue.use(Router)

export default new Router({
	mode: 'history',
	routes:[
		{path:'/login', name:'login', component: Login},
		{path:'/join', name:'join', component: Join},
		{path:'/myPage', name:'myPage', component: MyPage},
		{path:'/myPageUpdate', name:'myPageUpdate', component:MyPageUpdate},
		{path:'/layout', name:'layout', component:Layout},
		{path:'/studentlist', name:'studentlist', component:StudentList},
		{path:'/studentfindsome', name:'studentfindsome', component: StudentFindSome},
		{path:'/studentfindone', name:'studentfindone', component: StudentFindOne}
		
	]
})