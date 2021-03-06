import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export const store = new Vuex.Store({
	state:{
		loginedUid:'',
		loginedPwd:'',
		id:'',
		name:'',
		birthday:'',
		gender:'',
		hak:'',
		ban:'',
		score:'',
		person:{},
		role:'',
		authCheck: false,
		sidebar: 'pre-sidebars',
		headerMessage:'공통 화면',
		searchWord:''
	}
})