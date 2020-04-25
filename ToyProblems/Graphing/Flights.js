const airports = 'PHX BKK OKC JFK LAX MEX EZE HEL LOS LAP LIM'.split(' ');
const routes = [
    ['PHX', 'LAX'],
    ['PHX', 'JFK'],
    ['JFK', 'OKC'],
    ['JFK', 'HEL'],
    ['JFK', 'LOS'],
    ['MEX', 'LAX'],
    ['MEX', 'BKK'],
    ['MEX', 'LIM'],
    ['MEX', 'EZE'],
    ['LIM', 'BKK'],
]

const adjacencyList = new Map();
function addNode(airport){
    adjacencyList.set(airport, []);
}
function addEdge(origin, destination){
    adjacencyList.get(origin).push(destination);
    adjacencyList.get(destination).push(origin);
}

airports.forEach(addNode);
routes.forEach(route => addEdge(...route))//rest syntax for indefinite number of input routes

function bfs(start, end){ //find all routes
    const visited = new Set();
    const queue = [start]
    while(queue.length > 0){
        const airport = queue.shift()
        const destinations = adjacencyList.get(airport);
        for(const destination of destinations){
            if (destination=== end){
                console.log('BFS found ' + end + '!')
            }
            if(!visited.has(destination)){
                visited.add(destination);
                console.log(destination)

                queue.push(destination);
            }
        }
    }
}

function dfs(start, end, visited = new Set()){
    console.log(start)
    visited.add(start);
    const destinations = adjacencyList.get(start);
    for(const destination of destinations){
        if (destination === end){
            console.log('DFS found Bankok' + end + '!')
            return;
        }
        if(!visited.has(destination)){
            dfs(destination, end, visited)
        }
    }
}

console.log(adjacencyList);

console.log("BFS:============================================")
bfs('PHX', 'BKK')
console.log("DFS:============================================")
dfs ('PHX', 'BKK')