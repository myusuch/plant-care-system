// Angular Library
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Component
import { PlantCareSystemComponent } from './plant-care-system.component';

const appRoutes: Routes = [
  {
    path: '',
    component: PlantCareSystemComponent,
    children: [
      {
        path: '',
        redirectTo: 'plant-care-system',
        pathMatch: 'full'
      },
      {
        path: 'plant-care-system',
        component: PlantCareSystemComponent
      },

    ]
  },
];

@NgModule({
  imports: [
    RouterModule.forChild(appRoutes)
  ],
  exports: [RouterModule]
})

export class PlantCareSystemRoutingModule {}
