import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {



  constructor() { }

  ngOnInit(): void {
  }

  imgsrc: string = "./assets/cat.jpg"
  defaultimg: boolean = false;

  onClick(): void {
    this.defaultimg = !this.defaultimg;
    if(this.imgsrc){

    }
    else{
      this.imgsrc = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/11/14112506/Pembroke-Welsh-Corgi-standing-outdoors-in-the-fall.jpg"
    }
  }

}
