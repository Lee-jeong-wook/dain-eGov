import * as THREE from 'three';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';

const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera( 50, window.innerWidth / window.innerHeight, 1, 2000 );
camera.position.set(0, 10, 40);

const renderer = new THREE.WebGLRenderer();
renderer.setSize( window.innerWidth, window.innerHeight );
renderer.setAnimationLoop( animate );
document.body.appendChild( renderer.domElement );

const geometry = new THREE.BoxGeometry( 2, 1, 1 );
const material = new THREE.MeshBasicMaterial( { color: 0x00ff00 } );
const cube = new THREE.Mesh( geometry, material );

const raycaster = new THREE.Raycaster();
const mouse = THREE.Vector2;

window.addEventListener('click', (event) => {
    mouse.x = (event.clientX / window.innerWidth) * 2 - 1;
    mouse.y = -(event.clientY / window.innerHeight) * 2 + 1;
    
    raycaster.setFromCamera(mouse, camera);
    const intersects = raycaster.intersectObjects(scene.children);
    if (intersects.length <= 0) return;
    let clickedObject = intersects[0].object;
    let clickedName = clickedObject.name.replace(/\d+/g, "");
    let parentName = clickedObject.parent ? clickedObject.parent.name.replace(/\d+/g, "") : "";
    console.log(clickedName);
    if (parentName === "컴퓨터") {
        alert(clickedObject.parent.name);
    } else if (clickedName === "btn") {
        let num = clickedObject.name.match(/\d+/g);
        num = num ? num.join("") : "";
        const numArr = num.split("");
        if(computer[numArr[0]][num[1]] == 1){
			computer[numArr[0]][num[1]] = 0;
			clickedObject.material.color.set(0x0000dd);
		} else{
			computer[numArr[0]][num[1]] =1;
			clickedObject.material.color.set(0xdd0000);
		}
		console.log(computer);
    } else if (clickedName == "submit"){
		console.log(computer);
		fetch('/egov_war/updateComputer.do', {
            method: "POST",
            headers: {
                // "Content-Type": "application/json",
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                computer: computer,
            }),
        }).then(r => location.href=r.url);
}
});
const drawPart = (x, y, z) => {
    const group = new THREE.Group;
    group.name = "부품";
    group.add(draw(x, y, z, 5, 1, 2, 0x888888, 1, 0));

    group.add(draw(x - 2, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));
    group.add(draw(x -1.8, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));
    group.add(draw(x -1.6, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));
    group.add(draw(x -1.4, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));
    group.add(draw(x -1.2, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));
    group.add(draw(x -1.0, y, z + 1, 0.1, 0.3, 0.01, 0xccccff, 1, 0));

    group.add(draw(x, y - 0.1, z + 1, 1, 0.1, 0.01, 0xdfdfdf, 1, 0));
    group.add(draw(x + 1.4, y, z + 1, 1, 0.1, 0.01, 0x333333, 1, 0));

    group.add(draw(x + 2, y, z + 1, 0.01, 0.3, 0.01, 0xdfdfdf, 1, 0));
    group.add(draw(x + 2.3, y, z + 1, 0.01, 0.3, 0.01, 0xdfdfdf, 1, 0));
    group.add(draw(x + 2.15, y + 0.15, z + 1, 0.3, 0.01, 0.01, 0xdfdfdf, 1, 0));
    group.add(draw(x + 2.15, y - 0.15, z + 1, 0.3, 0.01, 0.01, 0xdfdfdf, 1, 0));
    return group;
}
/**
 * 
 * @param {*} x x좌표
 * @param {*} y y좌표
 * @param {*} z z좌표
 * @param {*} w 넓이
 * @param {*} h 길이
 * @param {*} d 깊이
 * @param {*} c 색
 * @param {*} o 투명도
 * @param {*} r 회전도
 * @returns 
 */
const draw = (x, y, z, w, h, d, c, o, r) => {
    const geo = new THREE.BoxGeometry( w, h, d );
    const material = new THREE.MeshBasicMaterial( { color: c , opacity: o, transparent: true, side: THREE.DoubleSide} );
    const box = new THREE.Mesh( geo, material );
    box.position.x = x;
    box.position.y = y;
    box.position.z = z;
    box.frustumCulled = false;
    box.rotateX = r;
    scene.add(box);
    return box;
}
const drawComputer = (x, y, z, n) => {
    const group = new THREE.Group;
    group.name = "컴퓨터" + n
    group.add(draw(x - 3, y + 4, z, 1, 12, 4, 0x131313, 1, 0));
    group.add(draw(x + 3, y + 4, z, 1, 12, 4, 0x131313, 1, 0));
    group.add(draw(x, y + 4, z - 1.5, 5, 12, 1, 0x131313, 1, 0));
    group.add(draw(x, y + 9.85, z, 5, 0.3, 4, 0x131313, 1, 0));
    group.add(draw(x, y + 4.5, z + 1.8, 5, 10.8, 0.1, 0xffffff, 0.5));

    group.add(drawPart(x, y, z));
    group.add(drawPart(x, y + 1, z));
    group.add(drawPart(x, y + 2, z));
    group.add(drawPart(x, y + 3, z));
    group.add(drawPart(x, y + 4, z));
    group.add(drawPart(x, y + 5, z));
    group.add(drawPart(x, y + 6, z));
    group.add(drawPart(x, y + 7, z));
    group.add(drawPart(x, y + 8, z));
    group.add(drawPart(x, y + 9, z));
    return group;
}
let number = 1;
for(let i = 0; i < computer.length; i++){
    for(let j = 0; j < computer[i].length; j++){
        if(computer[i][j] == 1){
            scene.add(drawComputer(-10 + j * 10, -2, i * 5 - 10, number++))
        }
    }
}
const drawRoom = (x, y, z) => {
    draw(x, y, z, 31, 1, 30, 0x666666, 1, 0);

    //벽
    draw(x - 15, y + 9.5, z, 1, 20, 30, 0x666666,1, 0);
    draw(x + 17, y + 9.5, z, 5, 20, 30, 0x666666,1, 0);
    draw(x, y + 9.5, z - 15, 31, 20, 1, 0x666666,1, 0);
    //기둥
    draw(x - 14, y + 9.51, z - 14, 1, 20, 1, 0x333333, 1, 0);
    draw(x + 14, y + 9.51, z - 14, 1, 20, 1, 0x333333, 1, 0);
    // 천장
    draw(x + 2, y + 20, z - 11.5, 35, 1, 8, 0x515151,1, 0);
    draw(x - 11.5, y + 20, z, 8, 1, 30, 0x515151,1, 0);

    drawInputPad(x + 17, y + 10, z + 15);
}
    const drawInputPad = (x, y, z) => {
        draw(x, y, z, 3, 8, 0.3, 0x313131, 1, 0);
        draw(x, y+ 0.5, z + 0.1, 2.8, 5, 0.3, 0xdddddd, 1, 0);
        //버튼
        for(let i = 0; i < computer.length; i++){
            for(let j = 0; j < computer[i].length; j++){
                const btn = draw(x + 0.7 * j - 0.6, y + 0.8 * (computer.length - i) - 1.5, z + 0.3, 0.5, 0.5, 0.3, 0x0000dd, 1, 0);
                btn.name = "btn" + i + "" + j;
                if(computer[i][j] == 1){
                    btn.material.color.set(0xdd0000);
                }
            }
        }
        draw(x, y-3.3, z + 0.2, 2.5, 0.7, 0.3, 0xdd0000, 1, 0).name = "submit";
}
drawRoom(0, -4.5, 0)

function animate() {

	renderer.render( scene, camera );

}
new OrbitControls(camera, document.body);