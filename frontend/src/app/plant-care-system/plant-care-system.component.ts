import { Component, OnInit} from '@angular/core';
import { PlantCareSystemComponentService } from './plant-care-system.service';
import { MatDialog, MatDialogRef} from '@angular/material/dialog';
import { DialogOverviewComponent} from './dialog-component';

@Component({
  selector: 'app-care-system',
  templateUrl: './plant-care-system.component.html',
  styleUrls: ['./plant-care-system.component.css']
})

export class PlantCareSystemComponent implements OnInit {
  tableData;

  constructor(
    private pcsService: PlantCareSystemComponentService,
    public matDialog: MatDialog
  ) {}

  ngOnInit(): void {

    this.initData();

  }

  initData(): void {



    this.pcsService.findAllPlants().subscribe(plants => {
      this.tableData = [...plants];
    });

  }

  updateDialog(plantDTO): void {
    let dialogRef: MatDialogRef<DialogOverviewComponent>;

    dialogRef = this.matDialog.open(DialogOverviewComponent, {
      width: '40%',
      disableClose: true
    });

    dialogRef.componentInstance.plant = plantDTO;

    dialogRef.afterClosed().subscribe(updateWateredDate => {
      if (updateWateredDate === 0 ||  updateWateredDate > 0) {

        const plantUpdatedDTO = Object.assign({}, plantDTO);
        plantUpdatedDTO.lastWateredDate = updateWateredDate;

        this.pcsService.updatePlant(plantUpdatedDTO).subscribe(() => {
          this.ngOnInit();
        });

      }
    });
  }

}


