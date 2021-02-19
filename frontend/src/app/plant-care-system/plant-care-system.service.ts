import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';


@Injectable()
export class PlantCareSystemComponentService {
  constructor(
    private http: HttpClient
  ) {}

  findAllPlants(): any {
    const apiRoot = 'http://localhost:8080/plant/all';
    const apiURL = `${apiRoot}`;

    return this.http.get(apiURL).pipe(
      map(res => {
        return res;
      })
    );
  }

  updatePlant(plant: Plant): any {
    const apiRoot = 'http://localhost:8080/plant/update';
    const apiURL = `${apiRoot}`;

    return this.http.put(apiURL, plant).pipe(
      map(res => {
        return res;
      })
    );
  }

}

export class Plant {
  id: number;
  plantName: string;
  lastWateredDate: number;
  wateringFrequency: number;
}
