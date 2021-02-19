// Angular Library
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Component
import { AppComponent } from './app.component';

const appRoutes: Routes = [
  {
    path: '',
    component: AppComponent,
    children: [
      {
        path: '',
        redirectTo: 'app',
        pathMatch: 'full'
      },
      {
        path: 'app',
        loadChildren: () => import('./plant-care-system/plant-care-system.module').then(m => m.PlantCareSystemModule)
      },

    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule {}
