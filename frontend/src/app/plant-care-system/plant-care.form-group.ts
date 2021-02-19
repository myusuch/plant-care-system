import {FormGroup, FormControl} from '@angular/forms';

export class PlantCareFormGroup extends FormGroup {

  constructor() {
    super({
      lastWateredDate: new FormControl()
    });
  }
}
