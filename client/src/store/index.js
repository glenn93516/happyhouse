import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const localAccessToken = () => {
    const authtoken = localStorage.getItem("auth-token");
    if (!authtoken)
        return;
    axios.defaults.headers.common["auth-token"] = authtoken;
}

localAccessToken();

export default new Vuex.Store({
    state: {
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
        }
    },
    mutations: {
        LOGIN(state, payload) {
        state.accessToken = payload["auth-token"];
        state.userid = payload["userid"];
        state.username = payload["username"];
    
            localStorage["auth-token"] = payload["auth-token"];
        },
        LOGOUT(state) {
            state.accessToken = null;
            state.userid = "";
            state.username = "";
            localStorage["auth-token"] = null;
        },
        setAuth(state, payload) {
            state.accessToken = payload;
        }
    },
    actions: {
        LOGIN(context, user) {
            return axios.post('http://localhost:8097/happyhouse/members/login', user)
                .then((response) => {
                    console.log(response); // TODO : 테스트
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
