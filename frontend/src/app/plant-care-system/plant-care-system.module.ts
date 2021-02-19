import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlantCareSystemComponent} from './plant-care-system.component';
import { PlantCareSystemRoutingModule } from './plant-care-system-routing.module';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import { PlantCareSystemComponentService } from './plant-care-system.service';
import {DialogOverviewComponent} from './dialog-component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  imports: [
    CommonModule,
    PlantCareSystemRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    FormsModule,
    MatButtonModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  declarations: [
    PlantCareSystemComponent,
    DialogOverviewComponent
  ],
  providers: [
    PlantCareSystemComponentService,
  ],
  entryComponents: [
    DialogOverviewComponent
  ]
})
export class PlantCareSystemModule { }
