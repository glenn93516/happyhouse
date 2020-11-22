<template>
    <div>
        <h1>내페이지 정보</h1>
        <img src="./../assets/profile.png" width="300px;" style="margin-left:30px;" />
        <div class="d-flex justify-content-center" style="margin-top: 20px">
            <table v-show="myinfo" style="width: 600px; table-layout: fixed" id="myinfotable">
            <thead>
                <tr class="table-primary">
                <th>내 정보</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{{ info.userid }}</td>
                    <td>{{ info.username }}</td>
                    <td>{{ info.useremail }}</td>
                    <td>{{ info.userphone }}</td>
                </tr>
            </tbody>
            </table>
        </div>
    </div>
</template>

<script>

export default {

}
</script>

<style>

</style>