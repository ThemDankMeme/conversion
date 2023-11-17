// Load a JSON file from browser or node transparently

// This assumes ES6 loading (for both Node and Browser)

// It's called getRelativeJson because it doesn't expect
// any of the protocol or context, ONLY "./name.json" or
// "./js/name.json" and comes from the relative ORIGIN.

export async function getRelativeJson(name) {

    let g = get_node_global();

    if(g) {

        let fsPromises = await import('fs/promises');
        return JSON.parse(await fsPromises.readFile(name));
    }

    let w = get_browser_window();
    if(w) { return await (await fetch(name)).json(); }

    throw new Error("Unable to determine node vs browser");
}

function get_node_global() {
    try {
        return eval("global");
    } catch {
        return undefined;
    }
}

function get_browser_window() {
    try {
        return eval("window");
    } catch {
        return undefined;
    }
}