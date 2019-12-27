<template>
<div>
	<h2>관리자 페이지</h2>
	<input type="button" value="수정페이지 이동" @click="goUpdate"/>
</div>
</template>
<script>
export default{
	data(){
		return{}
	},
	methods:{
    goUpdate(){
    alert('업데이트 페이지 넘어가는것')
     this.$router.push({path:'/myPageUpdate'})
  }
  }
}
</script>
<style scoped>
</style>