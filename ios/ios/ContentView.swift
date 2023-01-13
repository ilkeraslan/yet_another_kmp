//
//  ContentView.swift
//  ios
//
//  Created by Ilker Aslan on 04/12/22.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text("Hello, world!")
                .padding()
                .font(.title)
                .foregroundColor(.cyan)
            
            Text("This is your subtitle!")
                .padding()
                .font(.title2)
                .foregroundColor(.black)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
