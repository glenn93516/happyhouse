import Vue from "vue";

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

import { faSearch } from "@fortawesome/free-solid-svg-icons";
import { faSortNumericUp, faSortNumericDown, faSortAlphaUp, faSortAlphaDown, faSortAmountUp } from "@fortawesome/free-solid-svg-icons";
import { faList, faBorderAll } from "@fortawesome/free-solid-svg-icons";

library.add(faSearch);
library.add(faSortNumericUp);
library.add(faSortNumericDown);
library.add(faSortAlphaUp);
library.add(faSortAlphaDown);
library.add(faSortAmountUp);
library.add(faList);
library.add(faBorderAll);


Vue.component("font-awesome-icon", FontAwesomeIcon);