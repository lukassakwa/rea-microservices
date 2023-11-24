import {Router} from '@angular/router';
import {Component} from "@angular/core";
import {KEYCLOAK_INITIALIZER} from "./app.module";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    title = 'Real Estate Aggregator';
    showPanel = false;

    constructor(
        private router: Router
    ) {

    }

    isLoggedIn() {
        return !!KEYCLOAK_INITIALIZER.token;
    }

    logout() {
      KEYCLOAK_INITIALIZER.logout();
    }

    togglePanel() {
        this.showPanel = !this.showPanel;
    }

    hidePanel() {
        this.showPanel = false;
    }
}
