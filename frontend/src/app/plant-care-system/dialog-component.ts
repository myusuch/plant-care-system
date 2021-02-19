import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {PlantCareFormGroup} from './plant-care.form-group';

@Component({
  selector: 'app-dialog-overview-example-dialog',
  templateUrl: 'dialog-component.html',
  styleUrls: ['./dialog-component.css']

})
export class DialogOverviewComponent implements OnInit {
  plant;
  plantCareFormGroup: PlantCareFormGroup;

  constructor(
    public dialogRef: MatDialogRef<DialogOverviewComponent>,
  ) {}

  ngOnInit(): void {
    this.plantCareFormGroup = new PlantCareFormGroup();
  }

  onNoClick(): void {
    this.dialogRef.close(false);
  }

  onSaveClick(): void {
    if (this.plantCareFormGroup.value.lastWateredDate != null) {
      this.dialogRef.close(this.plantCareFormGroup.value.lastWateredDate);
    }
  }

}



