<template> 
<div>
<div class="login-form">
<form>
	<h2 class="text-center">조건 검색</h2>  
		<div class="form-group">
	</div>
<!-- 	<a  v-for="findTop of sidebars" :key="i.menu">{{}}</a> -->
<!-- <li v-for="i of sidebars" :key="i.menu">
				<router-link :to="i.link">{{i.menu}}</router-link>
			</li> -->
		<!-- 	 {
			sidebars : [
				{menu:"게시글 목록",link:"/list"},
				{menu:"게시글 검색",link:"/search"}
			]
		} -->
		<li v-for="i of searchWords" :key="i.menu">
				<a @click.prevent="findTop(i.searchWordm)" >{{i.menu}}</a>
			</li>
<!-- 	<a @click.prevent="namesOfStudents">1. 학생의 이름</a>
	<a @click.prevent="streamToArray">2. 스트림을 배열로 전환</a>
	<a @click.prevent="streamToMap">3. 스트림을 맵으로 전환. 학생이름이  key</a>
	<a @click.prevent="theNumberOfStudents">4. 학생의 수</a>
	<a @click.prevent="totalScore">5. 학생들 총점</a>
	<a @click.prevent="topStudent">6. 1등 학생</a>
	<a @click.prevent="getStat">7. 전체 학생 성적 통계</a>
	<a @click.prevent="nameList">8. 전체 학생 이름</a>
	<a @click.prevent="partioningBy">1.단순분할 (성별로 분할)</a>
	<a @click.prevent="partioningCountPerGender">2.단순분할 (성별 학생수)</a>
	<a @click.prevent="partioningTopPerGender">3.단순분할 (성별 1등)</a>
	<a @click.prevent="partioningRejectPerGender">4.다중분할 (성별 불합격자,  50점이하)</a>
	<a @click.prevent="groupingByBan">1. 단순 그룹화(반별로 그룹화)</a>
	<a @click.prevent="groupingByGrade">2. 단순그룹화(성적별로 그룹화)</a>
	<a @click.prevent="groupingByCountByLevel">3. 단순그룹화 + 통계(성적별 학생수))</a>
	<a @click.prevent="groupingByHakAndBan">4. 다중 그룹화 (학년별, 반별)</a>
	<a @click.prevent="groupingTopByHakAndBan">5. 다중 그룹화 +통계 (학년별, 반별  1등)</a>
	<a @click.prevent="groupingByStat">6. 다중그룹화 + 통계(학년별, 반별  성적그룹)</a> -->
	
</form>
<!-- 	<div>학생들 목록 
<table class="table"><tr>
<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
</tr>
<tr v-for="(j, i) of list" :key="j.id">
<td>{{i+1}}</td>
<td>{{j.userid}}</td>
<td>{{j.passwd}}</td>
<td>{{j.name}}</td>
<td>{{j.birthday}}</td>
<td>{{j.gender}}</td>
<td>{{j.hak}}</td>
<td>{{j.ban}}</td>
<td>{{j.score}}</td>
<td>{{j.role}}</td>
</tr>
</table>
</div> -->
</div>
</div>
</template>
<script>
import axios from 'axios'
/* import {store} from 'store' */
export default{
data(){
	return {
		context: 'http://localhost:8080/',
		list: [],
		searchWord:'',
		
		searchWords : [
				{menu:"1. 학생의 이름", searchWordm:"namesOfStudents"},
				{menu:"2. 스트림을 배열로 전환",searchWordm:"streamToArray"},
				{menu:"3. 스트림을 맵으로 전환. 학생이름이  key",searchWordm:"streamToMap"},
				{menu:"4. 학생의 수",searchWordm:"theNumberOfStudents"},
				{menu:"5. 학생들 총점",searchWordm:"totalScore"},
				{menu:"6. 1등 학생",searchWordm:"topStudent"},
				{menu:"7. 전체 학생 성적 통계",searchWordm:"getStat"},
				{menu:"8. 전체 학생 이름",searchWordm:"nameList"},
				{menu:"1.단순분할 (성별로 분할)",searchWordm:"partioningBy"},
				{menu:"2.단순분할 (성별 학생수)",searchWordm:"partioningCountPerGender"},
				{menu:"3.단순분할 (성별 1등)",searchWordm:"partioningTopPerGender"},
				{menu:"4.다중분할 (성별 불합격자,  50점이하)",searchWordm:"partioningRejectPerGender"},
				{menu:"1. 단순 그룹화(반별로 그룹화)",searchWordm:"groupingByBan"},
				{menu:"2. 단순그룹화(성적별로 그룹화)",searchWordm:"groupingByGrade"},
				{menu:"3. 단순그룹화 + 통계(성적별 학생수))",searchWordm:"groupingByCountByLevel"},
				{menu:"4. 다중 그룹화 (학년별, 반별)",searchWordm:"groupingByHakAndBan"},
				{menu:"5. 다중 그룹화 +통계 (학년별, 반별  1등)",searchWordm:"groupingTopByHakAndBan"},
				{menu:"6. 다중그룹화 + 통계(학년별, 반별  성적그룹)",searchWordm:"groupingByStat"}
			]
	}
},
methods:{
	find(){
		axios.get(`${this.context}/students`)
		.then(res=>{
			this.list = res.data
		})
		.catch(e=>{
			alert('AXIOS FAIL'+e)
		})
	},
	findTop(){
		alert(`${this.i.searchWordm}`)
	
	/* 	this.searchWord = searchWords.searchWord */
		/* alert(`${this.searchWords}`) */
		axios.get(`${this.context}/students/searchWord`)
		/* .then(res=>{
			this.list = res.data
		}).catch(e=>{
			alert('AXIOS FAIL'+e)
		}) */
	}
}
}
</script>
<style scoped>
.login-form {
width: 340px;
margin: 50px auto;
}
.login-form form {
margin-bottom: 15px;
background: #f7f7f7;
box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
padding: 30px;
}
.login-form h2 {
margin: 0 0 15px;
}
.form-control, .btn {
min-height: 38px;
border-radius: 2px;
}
.btn {        
font-size: 15px;
font-weight: bold;
}
</style>