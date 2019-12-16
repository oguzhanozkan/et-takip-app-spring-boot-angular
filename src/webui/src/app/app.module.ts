import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app.routing.module';
import {AppLayoutComponent, FooterComponent, HeaderComponent, SidebarComponent} from "./_layout";
import {BsDatepickerModule, BsDropdownModule, CollapseModule, ModalModule, PaginationModule} from "ngx-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {ApiService} from "./services/api.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {CustomerService} from "./services/shared/customer.service";
import {UserService} from "./services/shared/user.service";
import {ProcessService} from "./services/shared/process.service";
import {ProcessSubService} from "./services/shared/processSub.service";

@NgModule({
    declarations: [
        AppComponent,
        AppLayoutComponent,
        FooterComponent,
        HeaderComponent,
        SidebarComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule,
        AppRoutingModule,
        NgxDatatableModule,
        CollapseModule.forRoot(),
        BsDropdownModule.forRoot(),
        ModalModule.forRoot(),
        FormsModule,
        ReactiveFormsModule
    ],
    providers: [ApiService,CustomerService,UserService,ProcessService,ProcessSubService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
