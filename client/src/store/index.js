import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        isAuthenticated: false,
        accessToken: null,
        userid: "",
        username: ""
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
        getIsAuthenticated(state) {
            return state.isAuthenticated;
        }
    },
    mutations: {
        LOGIN(state, payload) {
            state.accessToken = payload["auth-token"];
            state.userid = payload["userid"];
            state.username = payload["username"];
            state.isAuthenticated = true;
            localStorage["auth-token"] = payload["auth-token"];
        },
        LOGOUT(state) {
            console.log("store LOGOUT called");
            state.accessToken = null;
            state.userid = "";
            state.username = "";
            state.isAuthenticated = false;
            localStorage["auth-token"] = "";
        },
        setAuth(state, payload) {
            state.accessToken = payload;
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
            axios.defaults.headers.common["auth-token"] = undefined;
        }
    },
    modules: {}
});
