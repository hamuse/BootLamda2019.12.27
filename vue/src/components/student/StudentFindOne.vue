<template>
<div>
	<div class="login-form">
    <form>
        <h2 class="text-center">학번 검색</h2>       
        <div class="form-group">
            <input v-model="searchWord" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <button @click.prevent="find" class="btn btn-primary btn-block">찾기</button>
        </div>
	</form>

</div>
</div>
</template>
<script>
</script>
<style scoped>

</style>