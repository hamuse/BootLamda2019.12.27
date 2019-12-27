<template>
	<div id="app">
		<layout>
			<template #header="header">
				<h1>{{header.title}}</h1>
				<component :is="!loginCheck ? 'pre-auth' : 'post-auth'"></component>
			</template>
		<template #sidebar="sidebar">
			<!-- 	<div v-switch="sidebarCheck">
					<div v-case="'preSidebar'">
						<component :is="'pre-Sidebar'"></component>
					</div>
					<div v-case="'managerSidebar'">
						<component :is="'manager-Sidebar'"></component>
					</div>
					<div v-case="'studentSidebar'">
						<component :is="'student-Sidebar'"></component>
					</div>
				</div> -->
				<component :is="sidebarCheck"></component>
			</template>
			<template #content="content"><router-view/></template>
			<template #footer="footer">{{footer.title}}</template>
		</layout>
	</div>
</template>
<script>
import Layout from "@/components/cmm/Layout.vue"
import PreAuth from "@/components/cmm/PreAuth.vue"
import PostAuth from "@/components/cmm/PostAuth.vue"
import ManagerSidebars from "@/components/cmm/ManagerSidebars.vue"
import PreSidebars from "@/components/cmm/PreSidebars.vue"
import StudentSidebars from "@/components/cmm/StudentSidebars.vue"
import {store} from "@/store"
export default {
	components: {Layout,PreAuth,PostAuth,ManagerSidebars,PreSidebars,StudentSidebars},
	data(){
		return{}
	},
	computed:{
		loginCheck: function(){
			return store.state.authCheck
		},
		sidebarCheck: function(){
			return store.state.sidebar
		}
	}
}
</script>
<style scoped>
#divid{
	float: right;
}
ul.menu {
    position:relative;
    padding: 5px 5px 5px 5px;
    list-style: none;
    font-style: italic;
}
ul.menu a {
    text-decoration:none;
}
ul li {
	background-color: skyblue;
	
}
</style>