import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AppLayoutComponent} from "./_layout";

const routes: Routes = [
    {
        path: "", component: AppLayoutComponent,
        children: [
            {path: '', pathMatch: 'full', redirectTo: 'dashboard'},
            {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
            {path: 'customer', loadChildren: './pages/customer/customer.module#CustomerModule'},
            {path: 'process', loadChildren: './pages/process/process.module#ProcessModule'}
        ]
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
