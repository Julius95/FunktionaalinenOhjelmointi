'use strict'

const offset = [1,2];
const zoom = 2;
const phi = 180

const point = { x: 1, y: 1};

const pipeline  = [   // 2D-muunnoksia
    
    function translate(p){
        return { x: p.x + offset[0], y: p.y + offset[1] };
    },

    function scale(p){
        return { x: p.x * zoom, y: p.y * zoom};
    },
    
    function rotate(p){
      return { x: Math.round(p.x*Math.cos(phi*Math.PI/phi) - p.y * Math.sin(phi*Math.PI/phi),0),
          y: Math.round(p.x*Math.sin(phi*Math.PI/phi) + p.y * Math.cos(phi*Math.PI/phi), 0)
      };
    },
];
//x' = x*cos(phi) - y*sin(phi)
    
   // y' = x*sin(phi) + y*cos(phi)

function muunnos(point){
     for(let i=0; i<pipeline.length; i++){   
        point = pipeline[i](point);
    }
    return point;
}


console.log(point);
console.log(muunnos(point));
//console.log(rotate(point));