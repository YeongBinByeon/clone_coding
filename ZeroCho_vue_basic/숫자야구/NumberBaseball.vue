<template>
    <div>
        <h1>{{result}}</h1>
        <form v-on:submit="onSubmitForm">
            <input ref="answer" minlength="4" maxlength="4" v-model="value" />
            <button type="submit">입력</button>
        </form>
        <div>시도: {{tries.length}}</div>
        <ul>
            <li v-for="(t,index) in tries" v-bind:key="index">
                <div>{{t.try}}</div>
                <div>{{t.result}}</div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data(){
        return{
            tries:[],
            value:'',
            result:'',
        }
    },
    methods:{
        onSubmitForm(e){
            e.preventDefault();
            this.tries.push({
                try: this.value,
                result:'홈런',
            });
            this.value='';
            this.$refs.answer.focus();
        }
    }
};
</script>

<style>

</style>