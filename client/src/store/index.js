import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        isAuthenticated: false,
        accessToken: null,
        userid: "",
        username: "",
        useremail: "",
        userphone: "",
        role: ''
    },
    getters: {
        getAccessToken(state) {
            return state.accessToken;
        },
        getUserid(state) {
            return state.userid;
        },
        getUsername(state) {
            return state.username;
        },
        getUseremail(state) {
            return state.useremail;
        },
        getUserphone(state) {
            return state.userphone;
        },
        getIsAuthenticated(state) {
            return state.isAuthenticated;
        },
    },
    mutations: {
        LOGIN(state, payload) {
            state.accessToken = payload["auth-token"];
            state.userid = payload["userid"];
            state.username = payload["username"];
            state.useremail = payload["useremail"];
            state.userphone = payload["userphone"];
            state.role = payload["role"];
            state.isAuthenticated = true;
            localStorage["auth-token"] = payload["auth-token"];
        },
        LOGOUT(state) {
            state.accessToken = null;
            state.userid = "";
            state.username = "";
            state.userphone = "";
            state.useremail = "";
            state.role = '';
            state.isAuthenticated = false;
            localStorage.removeItem('auth-token');
        },
        setAuth(state, payload) {
            state.accessToken = payload;
        },
        setInfo(state, payload) {
            state.accessToken = payload["auth-token"];
            state.userid = payload["userid"];
            state.username = payload["username"];
            state.useremail = payload["useremail"];
            state.userphone = payload["userphone"];
            state.role = payload["role"];
            state.isAuthenticated = true;
        }
    },
    actions: {
        LOGIN(context, user) {
            return axios.post('http://localhost:8097/happyhouse/members/login', user)
                .then((response) => {
                    context.commit("LOGIN", response.data);
                    axios.defaults.headers.common["auth-token"] = `${response.data["auth-token"]}`;
                })
        },
        LOGOUT(context) {
            context.commit("LOGOUT");
            axios.defaults.headers.common["auth-token"] = null;
        },
        setInfo(context) {
            axios.get('http://localhost:8097/happyhouse/members/info')
                .then(({ data }) => {
                    if (data.exp > (Date.now() / 1000)) {
                        context.commit('setInfo', data.user);
                    }
                })
        }
    },
    modules: {}
});
